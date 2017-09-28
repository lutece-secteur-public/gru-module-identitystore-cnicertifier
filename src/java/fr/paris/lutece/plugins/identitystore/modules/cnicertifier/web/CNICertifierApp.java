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
package fr.paris.lutece.plugins.identitystore.modules.cnicertifier.web;

import fr.paris.lutece.plugins.identitystore.modules.cnicertifier.service.ScannerException;
import fr.paris.lutece.plugins.identitystore.modules.cnicertifier.service.ScannerService;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.util.mvc.commons.annotations.Action;
import fr.paris.lutece.portal.web.xpages.XPage;
import fr.paris.lutece.portal.util.mvc.xpage.MVCApplication;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.portal.util.mvc.xpage.annotations.Controller;
import fr.paris.lutece.portal.web.upload.MultipartHttpServletRequest;
import fr.paris.lutece.util.httpaccess.HttpAccessException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;

/**
 * This class provides a simple implementation of an XPage
 */
@Controller( xpageName = "cnicertifier" , pageTitleI18nKey = "module.identitystore.cnicertifier.xpage.cnicertifier.pageTitle" , pagePathI18nKey = "module.identitystore.cnicertifier.xpage.cnicertifier.pagePathLabel" )
public class CNICertifierApp extends MVCApplication
{
    private static final String TEMPLATE_XPAGE = "/skin/plugins/identitystore/modules/cnicertifier/cnicertifier.html";
    private static final String VIEW_HOME = "home";
    private static final String ACTION_SCAN = "scan";
    private static final String PARAMETER_IMAGE = "image";
    private static final String PARAMETER_FILENAME = "filename";
    
    /**
     * Returns the content of the page cnicertifier. 
     * @param request The HTTP request
     * @return The view
     */
    @View( value = VIEW_HOME , defaultView = true )
    public XPage viewHome( HttpServletRequest request )
    {
        return getXPage( TEMPLATE_XPAGE, request.getLocale(  ) );
    }
    
    /**
     * Scan the uploaded image
     * @param request The HTTP request
     * @return The redirected page
     */
    @Action( ACTION_SCAN )
    public XPage doScan( HttpServletRequest request )
    {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
        FileItem fileItem = multipartRequest.getFile( PARAMETER_IMAGE );
        Map<String, FileItem> mapFiles = new HashMap<>();
        mapFiles.put( PARAMETER_IMAGE , fileItem );
        Map<String , List<String>> mapParams = new HashMap<>();
        List<String> listParamValues = new ArrayList<>();
        mapParams.put( PARAMETER_FILENAME, listParamValues );
        try
        {
            ScannerService.scan( mapParams , mapFiles , fileItem.getContentType() );
        }
        catch (ScannerException | HttpAccessException ex)
        {
            addError( "Error scanning CNI : " + ex.getMessage() );
            AppLogService.error( "Error scanning CNI : " + ex.getMessage() , ex);
        }
        return redirectView( request, VIEW_HOME );
    }
}
