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

/**
 * Cni
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CNI 
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
        private MRZ _mrz;
    
    
       /**
        * Returns the LastNameMrz
        * @return The LastNameMrz
        */ 
        public String getLastNameMrz()
        {
            return _strLastNameMrz;
        }
    
       /**
        * Sets the LastNameMrz
        * @param strLastNameMrz The LastNameMrz
        */ 
        @JsonProperty("last_name_mrz")
        public void setLastNameMrz( String strLastNameMrz )
        {
            _strLastNameMrz = strLastNameMrz;
        }
    
       /**
        * Returns the LastNameOcr
        * @return The LastNameOcr
        */ 
        public String getLastNameOcr()
        {
            return _strLastNameOcr;
        }
    
       /**
        * Sets the LastNameOcr
        * @param strLastNameOcr The LastNameOcr
        */ 
        @JsonProperty("last_name_ocr")
        public void setLastNameOcr( String strLastNameOcr )
        {
            _strLastNameOcr = strLastNameOcr;
        }
    
       /**
        * Returns the LastNameCorrected
        * @return The LastNameCorrected
        */ 
        public String getLastNameCorrected()
        {
            return _strLastNameCorrected;
        }
    
       /**
        * Sets the LastNameCorrected
        * @param strLastNameCorrected The LastNameCorrected
        */ 
        @JsonProperty("last_name_corrected")
        public void setLastNameCorrected( String strLastNameCorrected )
        {
            _strLastNameCorrected = strLastNameCorrected;
        }
    
       /**
        * Returns the FirstNameMrz
        * @return The FirstNameMrz
        */ 
        public String getFirstNameMrz()
        {
            return _strFirstNameMrz;
        }
    
       /**
        * Sets the FirstNameMrz
        * @param strFirstNameMrz The FirstNameMrz
        */ 
        @JsonProperty("first_name_mrz")
        public void setFirstNameMrz( String strFirstNameMrz )
        {
            _strFirstNameMrz = strFirstNameMrz;
        }
    
       /**
        * Returns the FirstNameOcr
        * @return The FirstNameOcr
        */ 
        public String getFirstNameOcr()
        {
            return _strFirstNameOcr;
        }
    
       /**
        * Sets the FirstNameOcr
        * @param strFirstNameOcr The FirstNameOcr
        */ 
        @JsonProperty("first_name_ocr")
        public void setFirstNameOcr( String strFirstNameOcr )
        {
            _strFirstNameOcr = strFirstNameOcr;
        }
    
       /**
        * Returns the FirstNameCorrected
        * @return The FirstNameCorrected
        */ 
        public String getFirstNameCorrected()
        {
            return _strFirstNameCorrected;
        }
    
       /**
        * Sets the FirstNameCorrected
        * @param strFirstNameCorrected The FirstNameCorrected
        */ 
        @JsonProperty("first_name_corrected")
        public void setFirstNameCorrected( String strFirstNameCorrected )
        {
            _strFirstNameCorrected = strFirstNameCorrected;
        }
    
       /**
        * Returns the BirthDateMrz
        * @return The BirthDateMrz
        */ 
        public String getBirthDateMrz()
        {
            return _strBirthDateMrz;
        }
    
       /**
        * Sets the BirthDateMrz
        * @param strBirthDateMrz The BirthDateMrz
        */ 
        @JsonProperty("birth_date_mrz")
        public void setBirthDateMrz( String strBirthDateMrz )
        {
            _strBirthDateMrz = strBirthDateMrz;
        }
    
       /**
        * Returns the BirthDateOcr
        * @return The BirthDateOcr
        */ 
        public String getBirthDateOcr()
        {
            return _strBirthDateOcr;
        }
    
       /**
        * Sets the BirthDateOcr
        * @param strBirthDateOcr The BirthDateOcr
        */ 
        @JsonProperty("birth_date_ocr")
        public void setBirthDateOcr( String strBirthDateOcr )
        {
            _strBirthDateOcr = strBirthDateOcr;
        }
    
       /**
        * Returns the BirthPlaceOcr
        * @return The BirthPlaceOcr
        */ 
        public String getBirthPlaceOcr()
        {
            return _strBirthPlaceOcr;
        }
    
       /**
        * Sets the BirthPlaceOcr
        * @param strBirthPlaceOcr The BirthPlaceOcr
        */ 
        @JsonProperty("birth_place_ocr")
        public void setBirthPlaceOcr( String strBirthPlaceOcr )
        {
            _strBirthPlaceOcr = strBirthPlaceOcr;
        }
    
       /**
        * Returns the BirthPlaceCorrected
        * @return The BirthPlaceCorrected
        */ 
        public String getBirthPlaceCorrected()
        {
            return _strBirthPlaceCorrected;
        }
    
       /**
        * Sets the BirthPlaceCorrected
        * @param strBirthPlaceCorrected The BirthPlaceCorrected
        */ 
        @JsonProperty("birth_place_corrected")
        public void setBirthPlaceCorrected( String strBirthPlaceCorrected )
        {
            _strBirthPlaceCorrected = strBirthPlaceCorrected;
        }
    
       /**
        * Returns the BirthPlaceExists
        * @return The BirthPlaceExists
        */ 
        public boolean getBirthPlaceExists()
        {
            return _bBirthPlaceExists;
        }
    
       /**
        * Sets the BirthPlaceExists
        * @param bBirthPlaceExists The BirthPlaceExists
        */ 
        @JsonProperty("birth_place_exists")
        public void setBirthPlaceExists( boolean bBirthPlaceExists )
        {
            _bBirthPlaceExists = bBirthPlaceExists;
        }
        
        
       /**
        * Returns the Mrz
        * @return The Mrz
        */ 
        public MRZ getMrz()
        {
            return _mrz;
        }
    
       /**
        * Sets the Mrz
        * @param mrz The Mrz
        */ 
        public void setMrz( MRZ mrz )
        {
            _mrz = mrz;
        }


}


