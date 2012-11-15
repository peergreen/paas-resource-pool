/**
 * JPaaS
 * Copyright 2012 Bull S.A.S.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * $Id:$
 */ 
package org.ow2.jonas.jpaas.resource.bean;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ow2.easybeans.osgi.annotation.OSGiResource;
import org.ow2.jonas.jpaas.container.manager.api.ContainerManager;
import org.ow2.jonas.jpaas.container.manager.api.ContainerManagerBeanException;
import org.ow2.jonas.jpaas.database.manager.api.DatabaseManager;
import org.ow2.jonas.jpaas.database.manager.api.DatabaseManagerBeanException;
import org.ow2.jonas.jpaas.iaas.manager.api.IaasManagerException;
import org.ow2.jonas.jpaas.iaas.manager.api.IIaasManager;
import org.ow2.jonas.jpaas.resource.api.ResourcePool;
import org.ow2.jonas.jpaas.resource.api.ResourcePoolBeanException;
import org.ow2.jonas.jpaas.router.manager.api.RouterManager;
import org.ow2.jonas.jpaas.router.manager.api.RouterManagerBeanException;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(mappedName="ResourcePoolBean")

@Local(ResourcePool.class)
@Remote(ResourcePool.class)
public class ResourcePoolBean  implements ResourcePool {
  /**
  * The logger
  */
  private Log logger = LogFactory.getLog(ResourcePoolBean.class);

  @OSGiResource
  private RouterManager routerEjb;

  @OSGiResource
  private ContainerManager containerEjb;

  @OSGiResource
  private DatabaseManager datatbaseEjb;

  @OSGiResource
  private IIaasManager iaasEjb;

  public ResourcePoolBean() {
  }

  public void getRouter(String routerName, String paasAgentName,
            String paasConfigurationName, Integer listenPort) throws ResourcePoolBeanException {
    logger.info("JPAAS-RESOURCE-POOL / getRouter called");
    try {
      routerEjb.createRouter(routerName, paasAgentName, paasConfigurationName, listenPort);
    } catch (RouterManagerBeanException e) {
      e.printStackTrace();
      logger.info("JPAAS-RESOURCE-POOL / Error CreateRouter");
    }

  }

  public void getContainer(String containerName, String paasAgentName,
            String paasConfigurationName, Integer listenPort) throws ResourcePoolBeanException {
    logger.info("JPAAS-RESOURCE-POOL / getContainer called");
    try {
       containerEjb.createContainer(containerName, paasAgentName, paasConfigurationName, listenPort);
     } catch (ContainerManagerBeanException e) {
       e.printStackTrace();
       logger.info("JPAAS-RESOURCE-POOL / Error CreateRouter");
     }

  }

  public void getDbExternal(String databaseName, String paasAgentName,
            String paasConfigurationName, Integer listenPort) throws ResourcePoolBeanException{
    logger.info("JPAAS-RESOURCE-POOL / getDbExternal called");
    try {
       datatbaseEjb.createDatabase(databaseName, paasAgentName, paasConfigurationName, listenPort);
     } catch (DatabaseManagerBeanException e) {
       e.printStackTrace();
       logger.info("JPAAS-RESOURCE-POOL / Error CreateRouter");
     }

  }

  public void getIaas(String computeName, String iaasConfigurationName) throws ResourcePoolBeanException{
    logger.info("JPAAS-RESOURCE-POOL / getIaas called");
    try {
       iaasEjb.createCompute(computeName, iaasConfigurationName);
     } catch (IaasManagerException e) {
       e.printStackTrace();
       logger.info("JPAAS-RESOURCE-POOL / Error CreateRouter");
     }

  }

}
