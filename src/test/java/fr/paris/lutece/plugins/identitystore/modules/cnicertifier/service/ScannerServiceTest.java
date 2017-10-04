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
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * ScannerServiceTest
 */
public class ScannerServiceTest
{
    private static final String JSON = "{" + "  \"data\": {" + "    \"mrz\": {" + "      \"id\": \"ID\"," + "      \"country\": \"FRA\","
            + "      \"last_name\": \"ALOIS\"," + "      \"adm_code\": \"<<<<<<\"," + "      \"emit_year\": 13," + "      \"emit_month\": 3,"
            + "      \"adm_code2\": \"753\"," + "      \"emit_code\": 819," + "      \"checksum_emit\": 2," + "      \"first_name\": \"PAUL\","
            + "      \"birth_year\": 80," + "      \"birth_month\": 1," + "      \"birth_day\": 21," + "      \"checksum_birth\": 0," + "      \"sex\": \"M\","
            + "      \"checksum\": 2" + "    }," + "    \"last_name_mrz\": \"ALOIS\"," + "    \"last_name_ocr\": \"ALOIS\","
            + "    \"last_name_corrected\": \"ALOIS\"," + "    \"first_name_mrz\": \"PAUL\"," + "    \"first_name_ocr\": \"PAUL\","
            + "    \"first_name_corrected\": \"PAUL\"," + "    \"birth_date_mrz\": \"21180\"," + "    \"birth_date_ocr\": \"21011980\","
            + "    \"birth_place_ocr\": \"PARIS\"," + "    \"birth_place_corrected\": \"PARIS\"," + "    \"birth_place_exists\": true,"
            + "    \"birth_place_similar\": [" + "      [" + "        \"PARIS\"," + "        100" + "      ]," + "      [" + "        \"PARDIES\","
            + "        83" + "      ]," + "      [" + "        \"PARISOT\"," + "        83" + "      ]," + "      [" + "        \"AGRIS\"," + "        80"
            + "      ]," + "      [" + "        \"ARBIS\"," + "        80" + "      ]" + "    ]" + "  },"
            + "  \"image_path\": \"uploads/47052cc1-84b8-40cf-a288-a161bf012513.jpg\"," + "  \"excel_data_path\": \"uploads/exported_data.xls\"" + "}";

    /**
     * Test of parse method, of class ScannerService.
     * 
     * @throws java.lang.Exception
     */
    @Test
    public void testParse( ) throws Exception
    {
        System.out.println( "parse" );
        CNI cni = ScannerService.parse( JSON );

        assertEquals( cni.getFirstName() , "PAUL" );
        assertEquals( cni.getLastName() , "ALOIS" );
        assertEquals( cni.getBirthDate() , "21/01/80" );
        assertEquals( cni.getBirthPlace() , "PARIS" );
        assertEquals( cni.getGender() , "2" );
        assertEquals( cni.getNumeroCNI() , "130375300819" );
    }

}
