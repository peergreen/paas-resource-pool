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
package org.ow2.jonas.jpaas.resource.bean;

import org.ow2.jonas.jpaas.resource.api.ResourcePool;
import org.ow2.jonas.jpaas.resource.api.ResourcePoolBeanException;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(mappedName="ResourcePoolBean")
@Local(ResourcePool.class)
@Remote(ResourcePool.class)
public class ResourcePoolBean implements ResourcePool {

  public ResourcePoolBean() {
  }

  public void getRouter() throws ResourcePoolBeanException {
     //TODO
    System.out.println("JPAAS-RESOURCE-POOL / getRouter called");
  }

  public void getContainer() throws ResourcePoolBeanException {
    System.out.println("JPAAS-RESOURCE-POOL / getContainer called");
  }

  public void getDbExternal() throws ResourcePoolBeanException{
    System.out.println("JPAAS-RESOURCE-POOL / getDbExternal called");
  }

  public void getIaas() throws ResourcePoolBeanException{
    System.out.println("JPAAS-RESOURCE-POOL / getIaas called");
  }

}
