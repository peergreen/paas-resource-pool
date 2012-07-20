/**
 * JPaaS Util
 * Copyright (C) 2012 Bull S.A.S.
 * Contact: jasmine@ow2.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 * --------------------------------------------------------------------------
 * $Id$
 * --------------------------------------------------------------------------
 */
package org.ow2.jonas.jpaas.resource;

import org.ow2.easybeans.osgi.annotation.OSGiResource;
import org.ow2.jonas.jpaas.container.manager.api.ContainerManagerBeanException;
import org.ow2.jonas.jpaas.container.manager.bean.ContainerManagerBean;
import org.ow2.jonas.jpaas.database.manager.api.DatabaseManagerBeanException;
import org.ow2.jonas.jpaas.database.manager.bean.DatabaseManagerBean;
import org.ow2.jonas.jpaas.iaas.manager.api.IaasManagerException;
import org.ow2.jonas.jpaas.iaas.manager.bean.IaasManagerBean;
import org.ow2.jonas.jpaas.resource.pool.api.ResourcePoolBeanException;
import org.ow2.jonas.jpaas.resource.pool.api.ResourcePoolLocal;
import org.ow2.jonas.jpaas.resource.pool.api.ResourcePoolRemote;
import org.ow2.jonas.jpaas.router.manager.api.RouterManagerBeanException;
import org.ow2.jonas.jpaas.router.manager.bean.RouterManagerBean;
import org.ow2.util.log.Log;
import org.ow2.util.log.LogFactory;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(mappedName="ResourcePoolBean")
@Local(ResourcePoolLocal.class)
@Remote(ResourcePoolRemote.class)
public class ResourcePoolBean {
  /**
  * The logger
  */
  private Log logger = LogFactory.getLog(ResourcePoolBean.class);

  @OSGiResource
  private RouterManagerBean routerEjb;

  @OSGiResource
  private ContainerManagerBean containerEjb;

  @OSGiResource
  private DatabaseManagerBean datatbaseEjb;

  @OSGiResource
  private IaasManagerBean iaasEjb;

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
