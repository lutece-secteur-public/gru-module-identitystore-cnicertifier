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
 * Cni
 */

public class CNI
{
    private ScanOutput _scan;

    public CNI( ScanOutput scan )
    {
        _scan = scan;
    }

    /**
     * Returns the LastName
     * 
     * @return The LastName
     */
    public String getLastName( )
    {
        return _scan.getValidated( ).getLastName( );
    }

    /**
     * Returns the FirstName
     * 
     * @return The FirstName
     */
    public String getFirstName( )
    {
        return _scan.getValidated( ).getFirstName( );
    }

    /**
     * Returns the Birth Place
     * 
     * @return The Birth Place
     */
    public String getBirthPlace( )
    {
        return _scan.getValidated( ).getBirthPlace( );
    }

    /**
     * Gender conversion
     * 
     * @return The Gender in IDStore format
     */
    public String getGender( )
    {
        if ( _scan.getMrz( ).getSex( ).equals( "M" ) )
        {
            return "1";
        }
        else
            if ( _scan.getMrz( ).getSex( ).equals( "F" ) )
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
        return String.format( "%02d/%02d/%s", _scan.getMrz( ).getBirthDay( ), _scan.getMrz( ).getBirthMonth( ), _scan.getOcr( ).getBirthDate( )
                .substring( 4, 8 ) );
    }

    /**
     * Returns the CNI number
     * 
     * @return the CNI number
     */
    public String getNumeroCNI( )
    {
        return String.format( "%02d%02d%s%05d", _scan.getMrz( ).getEmitYear( ), _scan.getMrz( ).getEmitMonth( ), _scan.getMrz( ).getAdmCode2( ), _scan.getMrz( )
                .getEmitCode( ) );
    }

    /**
     * Returns the expiration date
     * 
     * @return the expiration date
     */
    public String getDateExpiration( )
    {
        return String.format( "01/%02d/20%02d", _scan.getMrz( ).getEmitMonth( ), _scan.getMrz( ).getEmitYear( ) + 10 );
    }
}
