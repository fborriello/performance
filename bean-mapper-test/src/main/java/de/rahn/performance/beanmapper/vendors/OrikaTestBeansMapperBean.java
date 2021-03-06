/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights reserved.
 */
package de.rahn.performance.beanmapper.vendors;

import javax.annotation.PostConstruct;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.frank_rahn.xmlns.types.testtypes._1.XmlTable;
import de.rahn.performance.beanmapper.AbstractTestBeansMapperBean;
import de.rahn.performance.beanmapper.TestBeansMapperBean;
import de.rahn.performance.testbeans.DomainTable;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Der Mapper für {@link MapperFacade}.
 * 
 * @author Frank W. Rahn
 */
@Component("Orika")
@Order(4)
public class OrikaTestBeansMapperBean extends AbstractTestBeansMapperBean {

	private MapperFacade orika;

	/**
	 * Initialisiere diese Spring-Bean.
	 */
	@PostConstruct
	public void initialize() {
		MapperFactory factory = new DefaultMapperFactory.Builder().build();
		orika = factory.getMapperFacade();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see TestBeansMapperBean#map(DomainTable)
	 */
	@Override
	public XmlTable map(DomainTable source) throws Exception {
		return orika.map(source, XmlTable.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see TestBeansMapperBean#map(XmlTable)
	 */
	@Override
	public DomainTable map(XmlTable source) throws Exception {
		return orika.map(source, DomainTable.class);
	}

}