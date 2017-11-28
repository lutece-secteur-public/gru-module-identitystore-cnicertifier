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

package fr.paris.lutece.plugins.identitystore.modules.cnicertifier.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Cni
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class CNI implements Serializable
{
    // Variables declarations
    private String _strLastNameMrz;
    private String _strLastNameOcr;
    private String _strLastNameCorrected;
    private String _strFirstNameMrz;
    private String _strFirstNameOcr;
    private String _strFirstNameCorrected;
    private String _strBirthDateMrz;
    private String _strBirthDateOcr;
    private String _strBirthPlaceOcr;
    private String _strBirthPlaceCorrected;
    private boolean _bBirthPlaceExists;
    private MRZData _mrz;

    /**
     * Returns the LastNameMrz
     * 
     * @return The LastNameMrz
     */
    public String getLastNameMrz( )
    {
        return _strLastNameMrz;
    }

    /**
     * Sets the LastNameMrz
     * 
     * @param strLastNameMrz
     *            The LastNameMrz
     */
    @JsonProperty( "last_name_mrz" )
    public void setLastNameMrz( String strLastNameMrz )
    {
        _strLastNameMrz = strLastNameMrz;
    }

    /**
     * Returns the LastNameOcr
     * 
     * @return The LastNameOcr
     */
    public String getLastNameOcr( )
    {
        return _strLastNameOcr;
    }

    /**
     * Sets the LastNameOcr
     * 
     * @param strLastNameOcr
     *            The LastNameOcr
     */
    @JsonProperty( "last_name_ocr" )
    public void setLastNameOcr( String strLastNameOcr )
    {
        _strLastNameOcr = strLastNameOcr;
    }

    /**
     * Returns the LastNameCorrected
     * 
     * @return The LastNameCorrected
     */
    public String getLastName( )
    {
        return _strLastNameCorrected;
    }

    /**
     * Sets the LastNameCorrected
     * 
     * @param strLastNameCorrected
     *            The LastNameCorrected
     */
    @JsonProperty( "last_name_corrected" )
    public void setLastNameCorrected( String strLastNameCorrected )
    {
        _strLastNameCorrected = strLastNameCorrected;
    }

    /**
     * Returns the FirstNameMrz
     * 
     * @return The FirstNameMrz
     */
    public String getFirstNameMrz( )
    {
        return _strFirstNameMrz;
    }

    /**
     * Sets the FirstNameMrz
     * 
     * @param strFirstNameMrz
     *            The FirstNameMrz
     */
    @JsonProperty( "first_name_mrz" )
    public void setFirstNameMrz( String strFirstNameMrz )
    {
        _strFirstNameMrz = strFirstNameMrz;
    }

    /**
     * Returns the FirstNameOcr
     * 
     * @return The FirstNameOcr
     */
    public String getFirstNameOcr( )
    {
        return _strFirstNameOcr;
    }

    /**
     * Sets the FirstNameOcr
     * 
     * @param strFirstNameOcr
     *            The FirstNameOcr
     */
    @JsonProperty( "first_name_ocr" )
    public void setFirstNameOcr( String strFirstNameOcr )
    {
        _strFirstNameOcr = strFirstNameOcr;
    }

    /**
     * Returns the FirstNameCorrected
     * 
     * @return The FirstNameCorrected
     */
    public String getFirstName( )
    {
        return _strFirstNameCorrected;
    }

    /**
     * Sets the FirstNameCorrected
     * 
     * @param strFirstNameCorrected
     *            The FirstNameCorrected
     */
    @JsonProperty( "first_name_corrected" )
    public void setFirstNameCorrected( String strFirstNameCorrected )
    {
        _strFirstNameCorrected = strFirstNameCorrected;
    }

    /**
     * Returns the BirthDateMrz
     * 
     * @return The BirthDateMrz
     */
    public String getBirthDateMrz( )
    {
        return _strBirthDateMrz;
    }

    /**
     * Sets the BirthDateMrz
     * 
     * @param strBirthDateMrz
     *            The BirthDateMrz
     */
    @JsonProperty( "birth_date_mrz" )
    public void setBirthDateMrz( String strBirthDateMrz )
    {
        _strBirthDateMrz = strBirthDateMrz;
    }

    /**
     * Returns the BirthDateOcr
     * 
     * @return The BirthDateOcr
     */
    public String getBirthDateOcr( )
    {
        return _strBirthDateOcr;
    }

    /**
     * Sets the BirthDateOcr
     * 
     * @param strBirthDateOcr
     *            The BirthDateOcr
     */
    @JsonProperty( "birth_date_ocr" )
    public void setBirthDateOcr( String strBirthDateOcr )
    {
        _strBirthDateOcr = strBirthDateOcr;
    }

    /**
     * Returns the BirthPlaceOcr
     * 
     * @return The BirthPlaceOcr
     */
    public String getBirthPlaceOcr( )
    {
        return _strBirthPlaceOcr;
    }

    /**
     * Sets the BirthPlaceOcr
     * 
     * @param strBirthPlaceOcr
     *            The BirthPlaceOcr
     */
    @JsonProperty( "birth_place_ocr" )
    public void setBirthPlaceOcr( String strBirthPlaceOcr )
    {
        _strBirthPlaceOcr = strBirthPlaceOcr;
    }

    /**
     * Returns the Birth Place
     * 
     * @return The Birth Place
     */
    public String getBirthPlace( )
    {
        return _strBirthPlaceCorrected;
    }

    /**
     * Sets the Birth Place
     * 
     * @param strBirthPlace
     *            The BirthPlace
     */
    @JsonProperty( "birth_place_corrected" )
    public void setBirthPlaceCorrected( String strBirthPlace )
    {
        _strBirthPlaceCorrected = strBirthPlace;
    }

    /**
     * Returns the BirthPlaceExists
     * 
     * @return The BirthPlaceExists
     */
    public boolean getBirthPlaceExists( )
    {
        return _bBirthPlaceExists;
    }

    /**
     * Sets the BirthPlaceExists
     * 
     * @param bBirthPlaceExists
     *            The BirthPlaceExists
     */
    @JsonProperty( "birth_place_exists" )
    public void setBirthPlaceExists( boolean bBirthPlaceExists )
    {
        _bBirthPlaceExists = bBirthPlaceExists;
    }

    /**
     * Returns the Mrz
     * 
     * @return The Mrz
     */
    public MRZData getMrz( )
    {
        return _mrz;
    }

    /**
     * Sets the Mrz
     * 
     * @param mrz
     *            The Mrz
     */
    public void setMrz( MRZData mrz )
    {
        _mrz = mrz;
    }

    /**
     * Gender conversion
     * 
     * @return The Gender in IDStore format
     */
    public String getGender( )
    {
        if ( _mrz.getSex( ).equals( "M" ) )
        {
            return "1";
        }
        else
            if ( _mrz.getSex( ).equals( "F" ) )
            {
                return "2";
            }
        return "0";
    }

    /**
     * Returns the birth date
     * 
     * @return The birth date
     */
    public String getBirthDate( )
    {
        return String.format( "%02d/%02d/%s", _mrz.getBirthDay( ), _mrz.getBirthMonth( ), _strBirthDateOcr.substring( 4, 8 ) );
    }

    /**
     * Returns the birth country
     * 
     * @return The birth country
     */
    public String getBirthCountry( )
    {
        return _mrz.getCountry( );
    }

    /**
     * Returns the CNI number
     * 
     * @return the CNI number
     */
    public String getNumeroCNI( )
    {
        return String.format( "%02d%02d%s%05d", _mrz.getEmitYear( ), _mrz.getEmitMonth( ), _mrz.getAdmCode2( ), _mrz.getEmitCode( ) );
    }

    /**
     * Returns the expiration date
     * 
     * @return the expiration date
     */
    public String getDateExpiration( )
    {
        return String.format( "01/%02d/20%02d", _mrz.getEmitMonth( ), _mrz.getEmitYear( ) + 10 );
    }
}
