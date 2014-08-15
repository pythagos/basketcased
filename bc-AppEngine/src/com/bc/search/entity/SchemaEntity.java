package com.bc.search.entity;


/**
 * @author Nabeel Mukhtar
 *
 */
import java.io.Serializable;
import java.util.logging.Logger;


/**
 * The Class SchemaEntity.
 */
public abstract class SchemaEntity implements Serializable {

	/** The logger. */
    protected final Logger logger = Logger.getLogger(getClass().getCanonicalName());

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 298765432109654638L;
}
