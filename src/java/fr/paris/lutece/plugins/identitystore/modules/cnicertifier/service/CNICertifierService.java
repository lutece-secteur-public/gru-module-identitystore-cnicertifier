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
import fr.paris.lutece.plugins.identitystore.web.rs.dto.AttributeDto;
import fr.paris.lutece.plugins.identitystore.web.rs.dto.AuthorDto;
import fr.paris.lutece.plugins.identitystore.web.rs.dto.IdentityChangeDto;
import fr.paris.lutece.plugins.identitystore.web.rs.dto.IdentityDto;
import fr.paris.lutece.plugins.identitystore.web.service.IdentityService;
import fr.paris.lutece.portal.service.security.LuteceUser;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CNICertifierService
 */
public class CNICertifierService
{
    private static final String BEAN_IDENTITYSTORE_SERVICE = "identitystore-cnicertifier.identitystore.service";
    private static final String PROPERTY_IDENTITY_SERVICE_CLIENT_CODE = "identitystore-cnicertifier.identitystore.client.code";
    private static final String CERTIFIER_CODE = "cnicertifier";
    private static final String CLIENT_CODE = AppPropertiesService.getProperty( PROPERTY_IDENTITY_SERVICE_CLIENT_CODE );

    /**
     * Certify attributes
     * 
     * @param user
     *            The Lutece User
     * @param cni
     *            The CNI
     */
    public void certify( LuteceUser user, CNI cni )
    {
        IdentityService identityService = SpringContextService.getBean( BEAN_IDENTITYSTORE_SERVICE );

        IdentityChangeDto identityChange = new IdentityChangeDto( );
        IdentityDto identity = new IdentityDto( );

        identity.setConnectionId( user.getName( ) );
        Map<String, AttributeDto> mapAttributes = new ConcurrentHashMap<>( );
        addAttribute( mapAttributes, "gender", cni.getGender( ) );
        addAttribute( mapAttributes, "first_name", cni.getFirstName( ) );
        addAttribute( mapAttributes, "family_name", cni.getLastName( ) );
        addAttribute( mapAttributes, "birthdate", cni.getBirthDate( ) );
        addAttribute( mapAttributes, "birthplace", cni.getBirthPlace( ) );

        identity.setAttributes( mapAttributes );
        identityChange.setIdentity( identity );

        AuthorDto author = new AuthorDto( );
        author.setApplicationCode( CLIENT_CODE );
        identityChange.setAuthor( author );

        identityService.certifyAttributes( identityChange, CERTIFIER_CODE );
    }

    /**
     * Add attribute DTO to a map
     * 
     * @param map
     *            The map
     * @param strKey
     *            The attribute key
     * @param strValue
     *            The attribute value
     */
    private void addAttribute( Map<String, AttributeDto> map, String strKey, String strValue )
    {
        AttributeDto attribute = new AttributeDto( );
        attribute.setKey( strKey );
        attribute.setValue( strValue );
        map.put( attribute.getKey( ), attribute );
    }

}
