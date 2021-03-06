/*
 * Copyright (c) 2002-2017, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.identitystore.modules.cnicertifier.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.paris.lutece.plugins.identitystore.modules.cnicertifier.business.CNI;
import fr.paris.lutece.plugins.identitystore.modules.cnicertifier.business.ScanOutput;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;

/**
 * ScannerService
 */
public class ScannerService
{
    /** The extraction of the document within the image failed (extract_document() function failed). */
    private static final String ERROR_DOCUMENT_EXTRACTION_FAILED = "DOCUMENT_EXTRACTION_FAILED";

    /** The improvement of the extracted image failed (improve_image() function failed). */
    private static final String ERROR_IMAGE_IMPROVEMENT_FAILED = "IMAGE_IMPROVEMENT_FAILED";

    /** The image provided is too small, its smallest side is lower than 900 pixels. The image must be at least 900x900 pixels. */
    private static final String ERROR_IMG_SIZE_TOO_SMALL = "IMG_SIZE_TOO_SMALL";

    /** OCR data and MRZ data don't match (same_ocr_mrz() function returned False). */
    private static final String ERROR_INCONSISTENT_OCR_MRZ = "INCONSISTENT_OCR_MRZ";

    /** The checksum of the date of birth extracted from the MRZ (characters from 28 to 33 of the second line) is not valid. */
    private static final String ERROR_INVALID_BIRTHDATE_CHECKSUM = "INVALID_BIRTHDATE_CHECKSUM";

    /** The checksum of the first 12 characters of the second line of the MRZ is not valid. */
    private static final String ERROR_INVALID_EMIT_CHECKSUM = "INVALID_EMIT_CHECKSUM";

    /** The type of the file provided is neither jpg (JPEG) nor png (PNG) nor pdf (PDF), and is therefore not supported. */
    private static final String ERROR_INVALID_FILE_TYPE = "INVALID_FILE_TYPE";

    /** The checksum of the first line and the first 35 characters of the second line is not valid. */
    private static final String ERROR_INVALID_GLOBAL_CHECKSUM = "INVALID_GLOBAL_CHECKSUM";

    /** The first line (line 0) of the MRZ is not 36 characters long as expected. */
    private static final String ERROR_INVALID_LINE0_LENGTH = "INVALID_LINE0_LENGTH";

    /** The second line (line 1) of the MRZ is not 36 characters long as expected. */
    private static final String ERROR_INVALID_LINE1_LENGTH = "INVALID_LINE1_LENGTH";

    /** The first 2 characters of the first line of the MRZ are not ID as expected. */
    private static final String ERROR_INVALID_MRZ_ID = "INVALID_MRZ_ID";

    /** The MRZ data extracted does not contain 2 lines as expected. */
    private static final String ERROR_INVALID_MRZ_LINES_COUNT = "INVALID_MRZ_LINES_COUNT";

    /** The sex character extracted from the MRZ is neither M (male) nor F (female). */
    private static final String ERROR_INVALID_MRZ_SEX = "INVALID_MRZ_SEX";

    /** The image file is missing in the image field of the HTTP POST request. */
    private static final String ERROR_MISSING_IMAGE_FILE = "MISSING_IMAGE_FILE";

    /** The extraction of the MRZ failed (cni_mrz_extract() function failed). */
    private static final String ERROR_MRZ_EXTRACTION_FAILED = "MRZ_EXTRACTION_FAILED";

    /** The location of the different zones in the document failed (cni_locate_zone() function failed). */
    private static final String ERROR_ZONES_LOCATION_FAILED = "ZONES_LOCATION_FAILED";

    private static final String PROPERTY_SCANNER_URL = "identitystore-cnicertifier.scannerUrl";

    private static final String MESSAGE_IMG_SIZE_TOO_SMALL= "module.identitystore.cnicertifier.message.imageSizeTooSmall";
    private static final String MESSAGE_CHECK_FAILED = "module.identitystore.cnicertifier.message.checkFailed";
    private static final String MESSAGE_SCAN_FAILED = "module.identitystore.cnicertifier.message.scanFailed";
    private static final String MESSAGE_FILE_MISSING = "module.identitystore.cnicertifier.message.fileMissing";
    private static final String MESSAGE_INVALID_FILE_TYPE = "module.identitystore.cnicertifier.message.invalidFileType";
    
    private static ObjectMapper _mapper = new ObjectMapper( );
    private static ScannerResponseStatusValidator _validator = new ScannerResponseStatusValidator();

    /**
     * Scan the CNI
     *
     * @param mapFileItems
     *            Files
     * @return The CNI
     * @throws ScannerException
     * @throws HttpAccessException
     */
    public static CNI scan( Map<String, FileItem> mapFileItems ) throws ScannerException, HttpAccessException
    {
        HttpAccess client = new HttpAccess( _validator );
        
        String strURL = AppPropertiesService.getProperty( PROPERTY_SCANNER_URL );
        String strResponse = client.doPostMultiPart( strURL, null, mapFileItems );
        CNI cni = parse( strResponse );
        return cni;
    }

    /**
     * Parse the response of the scanner server
     * 
     * @param strJSON
     *            The response as JSON
     * @return The CNI object
     * @throws ScannerException
     *             A scanner exception
     */
    public static CNI parse( String strJSON ) throws ScannerException
    {
        CNI cni = null;

        try
        {
            JsonNode nodeRoot = _mapper.readTree( strJSON );
            JsonNode nodeData = nodeRoot.get( "data" );
            
            if( nodeData != null )
            {
                String strDataJSON = nodeData.toString( );
                ScanOutput scan = _mapper.readValue( strDataJSON, ScanOutput.class );
                cni = new CNI( scan );
            }
            else
            {
                String strCode = getField( nodeRoot , "code" );
                String strException = getField( nodeRoot , "exception" );
                String strMessage = getField( nodeRoot , "message" );
                String strUserMessage = handleError( strCode );
                throw new ScannerException( strMessage , strCode , strException , strUserMessage );
            }
        }
        catch( IOException ex )
        {
            throw new ScannerException( ex.getMessage( ) );
        }
        return cni;
    }

    /**
     * Handle an error code to produce an user message
     * @param strCode The error code
     * @return The user message
     */
    private static String handleError( String strCode )
    {
        if( ERROR_IMG_SIZE_TOO_SMALL.equals( strCode ))
        {
            return I18nService.getLocalizedString( MESSAGE_IMG_SIZE_TOO_SMALL, Locale.FRENCH );
        }
        if(     ERROR_INCONSISTENT_OCR_MRZ.equals( strCode) || 
                ERROR_INVALID_BIRTHDATE_CHECKSUM.equals( strCode ) ||
                ERROR_INVALID_EMIT_CHECKSUM.equals( strCode ) ||
                ERROR_INVALID_GLOBAL_CHECKSUM.equals( strCode ) ||
                ERROR_INVALID_MRZ_ID.equals( strCode ) ||
                ERROR_INVALID_MRZ_LINES_COUNT.equals( strCode ) ||
                ERROR_INVALID_MRZ_SEX.equals( strCode ))
        {
            return I18nService.getLocalizedString( MESSAGE_CHECK_FAILED, Locale.FRENCH );
        }    
        
        if( ERROR_MRZ_EXTRACTION_FAILED.equals( strCode ) ||
                ERROR_DOCUMENT_EXTRACTION_FAILED.equals( strCode ) ||
                ERROR_MRZ_EXTRACTION_FAILED.equals( strCode ) ||
                ERROR_IMAGE_IMPROVEMENT_FAILED.equals( strCode ) ||
                ERROR_INVALID_LINE0_LENGTH.equals( strCode ) ||
                ERROR_INVALID_LINE1_LENGTH.equals( strCode ) ||
                ERROR_ZONES_LOCATION_FAILED.equals( strCode ))
        {
            return I18nService.getLocalizedString( MESSAGE_SCAN_FAILED, Locale.FRENCH );
        }
        
        if( ERROR_INVALID_FILE_TYPE.equals( strCode ) )
        {
            return I18nService.getLocalizedString( MESSAGE_INVALID_FILE_TYPE, Locale.FRENCH );
        }
        
        if( ERROR_MISSING_IMAGE_FILE.equals( strCode ))
        {
            return I18nService.getLocalizedString( MESSAGE_FILE_MISSING, Locale.FRENCH );
        }
        
        return I18nService.getLocalizedString( MESSAGE_SCAN_FAILED, Locale.FRENCH );
    }

    /**
     * Gets field content avoiding null values for missing fields
     * @param nodeRoot The root
     * @param strField The field name
     * @return The field content
     */
    private static String getField( JsonNode nodeRoot, String strField  )
    {
        JsonNode node = nodeRoot.get( strField );
        return ( node != null ) ? node.asText() : "";
    }
}
