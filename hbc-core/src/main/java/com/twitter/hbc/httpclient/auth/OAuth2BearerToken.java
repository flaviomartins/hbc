/**
 * Copyright 2013 Twitter, Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.twitter.hbc.httpclient.auth;

import com.google.common.base.Preconditions;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;

public class OAuth2BearerToken implements Authentication {

  private final String bearerToken;

  public OAuth2BearerToken(String bearerToken) {
    this.bearerToken = Preconditions.checkNotNull(bearerToken);
  }

  @Override
  public void setupConnection(AbstractHttpClient client) {}

  @Override
  public void signRequest(HttpUriRequest request, String postParams) {
    request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken);
  }

  public String getUsername() {
      return null;
  }

  public String getPassword() {
     return null;
  }

}
