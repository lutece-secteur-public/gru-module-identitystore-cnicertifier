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

/**
 * OCRData
 */
public class OCRData 
{
    // Variables declarations 

    private String _strFirstName;
    private String _strLastName;
    private String _strBirthDate;
    private String _strBirthPlace;

    /**
     * Returns the FirstName
     *
     * @return The FirstName
     */
    public String getFirstName()
    {
        return _strFirstName;
    }

    /**
     * Sets the FirstName
     *
     * @param strFirstName The FirstName
     */
    public void setFirstName( String strFirstName )
    {
        _strFirstName = strFirstName;
    }

    /**
     * Returns the LastName
     *
     * @return The LastName
     */
    public String getLastName()
    {
        return _strLastName;
    }

    /**
     * Sets the LastName
     *
     * @param strLastName The LastName
     */
    public void setLastName( String strLastName )
    {
        _strLastName = strLastName;
    }

    /**
     * Returns the BirthDate
     *
     * @return The BirthDate
     */
    public String getBirthDate()
    {
        return _strBirthDate;
    }

    /**
     * Sets the BirthDate
     *
     * @param strBirthDate The BirthDate
     */
    public void setBirthDate( String strBirthDate )
    {
        _strBirthDate = strBirthDate;
    }

    /**
     * Returns the BirthPlace
     *
     * @return The BirthPlace
     */
    public String getBirthPlace()
    {
        return _strBirthPlace;
    }

    /**
     * Sets the BirthPlace
     *
     * @param strBirthPlace	The BirthPlace
     */
    public void setBirthPlace( String strBirthPlace )
    {
        _strBirthPlace = strBirthPlace;
    }


}
