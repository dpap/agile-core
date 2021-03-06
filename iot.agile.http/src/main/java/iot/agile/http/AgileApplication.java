/*******************************************************************************
 * Copyright (C) 2017 Create-Net / FBK.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Create-Net / FBK - initial API and implementation
 ******************************************************************************/
/*
 * Copyright 2016 CREATE-NET
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package iot.agile.http;

import iot.agile.http.exception.AgileExceptionMapper;
import iot.agile.http.filter.CORSResponseFilter;
import iot.agile.http.service.DbusClient;
import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Luca Capra <lcapra@create-net.org>
 */
@ApplicationPath("/")
public class AgileApplication extends ResourceConfig {

  protected class AgileBinder extends AbstractBinder {

    @Override
    protected void configure() {
      bind(DbusClient.class).to(DbusClient.class)
              .in(Singleton.class);
    }
  }

  public AgileApplication() {

    register(JacksonFeature.class);
    
    register(new AgileBinder());
    register(new AgileExceptionMapper());
    register(CORSResponseFilter.class);

    packages("iot.agile.http.resource;");
    

    
  }
}
