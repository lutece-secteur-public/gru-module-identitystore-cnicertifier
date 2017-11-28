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

import fr.paris.lutece.plugins.identitystore.modules.cnicertifier.business.CNI;
import fr.paris.lutece.plugins.identitystore.modules.cnicertifier.business.ScanOutput;
import fr.paris.lutece.test.Utils;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * ScannerServiceTest
 */
public class ScannerServiceTest
{

    /**
     * Test of parse method, of class ScannerService.
     * 
     * @throws java.lang.Exception
     */
    @Test
    public void testParse( ) throws Exception
    {
        System.out.println( "parse" );
        
        String strJSON = Utils.getFileContent( "scan_output.json");
        System.out.println( strJSON );
       
        CNI cni = ScannerService.parse( strJSON );

        assertEquals( cni.getFirstName( ), "PAUL" );
        assertEquals( cni.getLastName( ), "ALOIS" );
        assertEquals( cni.getBirthDate( ), "21/01/1980" );
        assertEquals( cni.getBirthPlace( ), "PARIS" );
        assertEquals( cni.getGender( ), "1" );
        assertEquals( cni.getNumeroCNI( ), "130375300819" );

    }

}
