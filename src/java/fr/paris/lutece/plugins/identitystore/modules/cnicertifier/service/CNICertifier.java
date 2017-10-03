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

import fr.paris.lutece.plugins.identitystore.modules.grucertifier.service.GruCertifier;
import fr.paris.lutece.portal.service.i18n.I18nService;
import java.util.Locale;

/**
 * CNICertifier
 */
public class CNICertifier extends GruCertifier
{

    private static final String MESSAGE_GRU_NOTIF_EMAIL_SENDER_NAME = "module.identitystore.fccertifier.gru.notif.senderName";
    private static final String MESSAGE_GRU_NOTIF_EMAIL_SENDER_MAIL = "module.identitystore.fccertifier.gru.notif.senderMail";
    private static final String MESSAGE_GRU_NOTIF_DASHBOARD_STATUS_TEXT = "module.identitystore.fccertifier.gru.notif.dashboard.statusText";
    private static final String MESSAGE_GRU_NOTIF_DASHBOARD_MESSAGE = "module.identitystore.fccertifier.gru.notif.dashboard.message";
    private static final String MESSAGE_GRU_NOTIF_DASHBOARD_SUBJECT = "module.identitystore.fccertifier.gru.notif.dashboard.subject";
    private static final String MESSAGE_GRU_NOTIF_DASHBOARD_DATA = "module.identitystore.fccertifier.gru.notif.dashboard.data";
    private static final String MESSAGE_GRU_NOTIF_DASHBOARD_SENDER_NAME = "module.identitystore.fccertifier.gru.notif.dashboard.senderName";
    private static final String MESSAGE_GRU_NOTIF_EMAIL_SUBJECT = "module.identitystore.fccertifier.gru.notif.email.subject";
    private static final String MESSAGE_GRU_NOTIF_EMAIL_MESSAGE = "module.identitystore.fccertifier.gru.notif.email.message";
    private static final String MESSAGE_GRU_NOTIF_AGENT_MESSAGE = "module.identitystore.fccertifier.gru.notif.agent.message";
    private static final String MESSAGE_GRU_NOTIF_AGENT_STATUS_TEXT = "module.identitystore.fccertifier.gru.notif.agent.statusText";

    /**
     * @param strCode
     */
    public CNICertifier( String strCode )
    {
        super( strCode );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initNotifyGruConfig( Locale locale )
    {
        // set Messages for Dashboard
        setMessageGruNotifDashboardMessage( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_DASHBOARD_MESSAGE, locale ) );
        setMessageGruNotifDashboardSenderName( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_DASHBOARD_SENDER_NAME, locale ) );
        setMessageGruNotifDashboardData( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_DASHBOARD_DATA, locale ) );
        setMessageGruNotifDashboardStatusText( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_DASHBOARD_STATUS_TEXT, locale ) );
        setMessageGruNotifDashboardSubject( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_DASHBOARD_SUBJECT, locale ) );

        // set Messages for Agent notification
        setMessageGruNotifAgentMessage( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_AGENT_MESSAGE, locale ) );
        setMessageGruNotifAgentStatusText( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_AGENT_STATUS_TEXT, locale ) );

        // set Messages for broadcast email notification
        setMessageGruNotifEmailMessage( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_EMAIL_MESSAGE, locale ) );
        setMessageGruNotifEmailSubject( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_EMAIL_SUBJECT, locale ) );
        setMessageGruNotifSenderName( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_EMAIL_SENDER_NAME, locale ) );
        setMessageGruNotifSenderMail( I18nService.getLocalizedString( MESSAGE_GRU_NOTIF_EMAIL_SENDER_MAIL, locale ) );
    }
}
