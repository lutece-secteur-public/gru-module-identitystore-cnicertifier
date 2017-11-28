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
 * MRZData
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class MRZData implements Serializable
{
    // Variables declarations
    private String _strId;
    private String _strCountry;
    private String _strLastName;
    private String _strAdmCode;
    private int _nEmitYear;
    private int _nEmitMonth;
    private String _strAdmCode2;
    private int _nEmitCode;
    private int _nChecksumEmit;
    private String _strFirstName;
    private int _nBirthYear;
    private int _nBirthMonth;
    private int _nBirthDay;
    private int _nChecksumBirth;
    private String _strSex;
    private int _nChecksum;

    /**
     * Returns the Id
     * 
     * @return The Id
     */
    public String getId( )
    {
        return _strId;
    }

    /**
     * Sets the Id
     * 
     * @param strId
     *            The Id
     */
    public void setId( String strId )
    {
        _strId = strId;
    }

    /**
     * Returns the Country
     * 
     * @return The Country
     */
    public String getCountry( )
    {
        return _strCountry;
    }

    /**
     * Sets the Country
     * 
     * @param strCountry
     *            The Country
     */
    public void setCountry( String strCountry )
    {
        _strCountry = strCountry;
    }

    /**
     * Returns the LastName
     * 
     * @return The LastName
     */
    public String getLastName( )
    {
        return _strLastName;
    }

    /**
     * Sets the LastName
     * 
     * @param strLastName
     *            The LastName
     */
    @JsonProperty( "last_name" )
    public void setLastName( String strLastName )
    {
        _strLastName = strLastName;
    }

    /**
     * Returns the AdmCode
     * 
     * @return The AdmCode
     */
    public String getAdmCode( )
    {
        return _strAdmCode;
    }

    /**
     * Sets the AdmCode
     * 
     * @param strAdmCode
     *            The AdmCode
     */
    @JsonProperty( "adm_code" )
    public void setAdmCode( String strAdmCode )
    {
        _strAdmCode = strAdmCode;
    }

    /**
     * Returns the EmitYear
     * 
     * @return The EmitYear
     */
    public int getEmitYear( )
    {
        return _nEmitYear;
    }

    /**
     * Sets the EmitYear
     * 
     * @param nEmitYear
     *            The EmitYear
     */
    @JsonProperty( "emission_year" )
    public void setEmitYear( int nEmitYear )
    {
        _nEmitYear = nEmitYear;
    }

    /**
     * Returns the EmitMonth
     * 
     * @return The EmitMonth
     */
    public int getEmitMonth( )
    {
        return _nEmitMonth;
    }

    /**
     * Sets the EmitMonth
     * 
     * @param nEmitMonth
     *            The EmitMonth
     */
    @JsonProperty( "emission_month" )
    public void setEmitMonth( int nEmitMonth )
    {
        _nEmitMonth = nEmitMonth;
    }

    /**
     * Returns the AdmCode2
     * 
     * @return The AdmCode2
     */
    public String getAdmCode2( )
    {
        return _strAdmCode2;
    }

    /**
     * Sets the AdmCode2
     * 
     * @param strAdmCode2
     *            The AdmCode2
     */
    @JsonProperty( "adm_code2" )
    public void setAdmCode2( String strAdmCode2 )
    {
        _strAdmCode2 = strAdmCode2;
    }

    /**
     * Returns the EmitCode
     * 
     * @return The EmitCode
     */
    public int getEmitCode( )
    {
        return _nEmitCode;
    }

    /**
     * Sets the EmitCode
     * 
     * @param nEmitCode
     *            The EmitCode
     */
    @JsonProperty( "emission_code" )
    public void setEmitCode( int nEmitCode )
    {
        _nEmitCode = nEmitCode;
    }

    /**
     * Returns the ChecksumEmit
     * 
     * @return The ChecksumEmit
     */
    public int getChecksumEmit( )
    {
        return _nChecksumEmit;
    }

    /**
     * Sets the ChecksumEmit
     * 
     * @param nChecksumEmit
     *            The ChecksumEmit
     */
    @JsonProperty( "checksum_emission" )
    public void setChecksumEmit( int nChecksumEmit )
    {
        _nChecksumEmit = nChecksumEmit;
    }

    /**
     * Returns the FirstName
     * 
     * @return The FirstName
     */
    public String getFirstName( )
    {
        return _strFirstName;
    }

    /**
     * Sets the FirstName
     * 
     * @param strFirstName
     *            The FirstName
     */
    @JsonProperty( "first_name" )
    public void setFirstName( String strFirstName )
    {
        _strFirstName = strFirstName;
    }

    /**
     * Returns the BirthYear
     * 
     * @return The BirthYear
     */
    public int getBirthYear( )
    {
        return _nBirthYear;
    }

    /**
     * Sets the BirthYear
     * 
     * @param nBirthYear
     *            The BirthYear
     */
    @JsonProperty( "birth_year" )
    public void setBirthYear( int nBirthYear )
    {
        _nBirthYear = nBirthYear;
    }

    /**
     * Returns the BirthMonth
     * 
     * @return The BirthMonth
     */
    public int getBirthMonth( )
    {
        return _nBirthMonth;
    }

    /**
     * Sets the BirthMonth
     * 
     * @param nBirthMonth
     *            The BirthMonth
     */
    @JsonProperty( "birth_month" )
    public void setBirthMonth( int nBirthMonth )
    {
        _nBirthMonth = nBirthMonth;
    }

    /**
     * Returns the BirthDay
     * 
     * @return The BirthDay
     */
    public int getBirthDay( )
    {
        return _nBirthDay;
    }

    /**
     * Sets the BirthDay
     * 
     * @param nBirthDay
     *            The BirthDay
     */
    @JsonProperty( "birth_day" )
    public void setBirthDay( int nBirthDay )
    {
        _nBirthDay = nBirthDay;
    }

    /**
     * Returns the ChecksumBirth
     * 
     * @return The ChecksumBirth
     */
    public int getChecksumBirth( )
    {
        return _nChecksumBirth;
    }

    /**
     * Sets the ChecksumBirth
     * 
     * @param nChecksumBirth
     *            The ChecksumBirth
     */
    @JsonProperty( "checksum_birth" )
    public void setChecksumBirth( int nChecksumBirth )
    {
        _nChecksumBirth = nChecksumBirth;
    }

    /**
     * Returns the Sex
     * 
     * @return The Sex
     */
    public String getSex( )
    {
        return _strSex;
    }

    /**
     * Sets the Sex
     * 
     * @param strSex
     *            The Sex
     */
    public void setSex( String strSex )
    {
        _strSex = strSex;
    }

    /**
     * Returns the Checksum
     * 
     * @return The Checksum
     */
    public int getChecksum( )
    {
        return _nChecksum;
    }

    /**
     * Sets the Checksum
     * 
     * @param nChecksum
     *            The Checksum
     */
    public void setChecksum( int nChecksum )
    {
        _nChecksum = nChecksum;
    }
}
