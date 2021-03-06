/*
 * MIT License
 *
 * Copyright (c) 2016 Asynchronous Game Query Library
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ibasco.agql.protocols.valve.steam.webapi;

import com.ibasco.agql.core.AbstractWebApiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a Steam API Request
 */
abstract public class SteamWebApiRequest extends AbstractWebApiRequest {
    private static final Logger log = LoggerFactory.getLogger(SteamWebApiRequest.class);

    private String steamApiInterface;
    private String steamApiMethod;

    public SteamWebApiRequest(String apiInterface, String apiMethod, int apiVersion) {
        super(apiVersion);
        this.steamApiInterface = resolveProperties(apiInterface);
        this.steamApiMethod = apiMethod;
        baseUrlFormat(SteamApiConstants.STEAM_BASE_URL_FORMAT);
        property(SteamApiConstants.STEAM_PROP_INTERFACE, this.steamApiInterface);
        property(SteamApiConstants.STEAM_PROP_METHOD, this.steamApiMethod);
        property(SteamApiConstants.STEAM_PROP_VERSION, apiVersion);
    }

    public String getSteamApiInterface() {
        return steamApiInterface;
    }

    public void setSteamApiInterface(String steamApiInterface) {
        this.steamApiInterface = steamApiInterface;
    }

    public String getSteamApiMethod() {
        return steamApiMethod;
    }

    public void setSteamApiMethod(String steamApiMethod) {
        this.steamApiMethod = steamApiMethod;
    }
}
