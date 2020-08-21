package com.cg.fms.util;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * @author nitesh
 *
 */
public class CustomNameStrategy extends PhysicalNamingStrategyStandardImpl {

	private static final long serialVersionUID = 1L;

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		String tableName = name.getText().concat("_tbl");
		Identifier identifier = new Identifier(tableName, name.isQuoted());
		return super.toPhysicalTableName(identifier, context);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		return super.toPhysicalColumnName(convertToSnakeCase(name), context);
	}

	private Identifier convertToSnakeCase(final Identifier identifier) {
		final String regex = "([a-z])([A-Z])";
		final String replacement = "$1_$2";
		final String newName = identifier.getText().replaceAll(regex, replacement).toLowerCase();
		return Identifier.toIdentifier(newName);
	}

}