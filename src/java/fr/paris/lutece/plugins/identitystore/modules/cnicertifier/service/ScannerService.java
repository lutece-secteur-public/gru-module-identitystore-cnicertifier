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
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;

/**
 * ScannerService
 */
public class ScannerService
{

    private static final String PROPERTY_SCANNER_URL = "identitystore-cnicertifier.scannerUrl";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    
    private static ObjectMapper _mapper = new ObjectMapper();

    /**
     * Scan the CNI
     *
     * @param mapParams Parameters
     * @param mapFileItems Files
     * @param strContentType The content type of the image
     * @return The CNI
     * @throws ScannerException
     * @throws HttpAccessException
     */
    public static CNI scan(Map<String, FileItem> mapFileItems ) throws ScannerException, HttpAccessException
    {
        CNI cni;
        HttpAccess client = new HttpAccess();
        String strURL = AppPropertiesService.getProperty(PROPERTY_SCANNER_URL);
        String strResponse = client.doPostMultiPart(strURL, null, mapFileItems );
        cni = parse(strResponse);
        return cni;
    }

    /**
     * Parse the response of the scanner server
     * @param strJSON The response as JSON
     * @return The CNI object
     * @throws ScannerException A scanner exception 
     */
    public static CNI parse(String strJSON) throws ScannerException
    {
        CNI cni = null;

        try
        {
            JsonNode nodeRoot = _mapper.readTree(strJSON);
            JsonNode nodeData = nodeRoot.get("data");
            String strDataJSON = nodeData.toString();
            cni = _mapper.readValue(strDataJSON, CNI.class);
        }
        catch (IOException ex)
        {
            throw new ScannerException(ex.getMessage());
        }
        return cni;
    }
}
