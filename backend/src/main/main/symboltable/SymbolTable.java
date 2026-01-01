package symboltable;

import ast.Definition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Temporary data structure that manages the scopes and definitions.
 */
public class SymbolTable {
	
	private int scope = 0; // By default, the first scope is 0 (global scope)
	private final List<Map<String,Definition>> table; // Each scope is a map of id to definition

	public SymbolTable()  {
		table = new ArrayList<>();
		table.add(new HashMap<>());
	}

	/**
	 * Creates a new scope.
	 */
	public void set() {
		this.scope++;
		table.add(new HashMap<>());
	}

	/**
	 * Removes the current scope.
	 */
	public void reset() {
		table.remove(this.scope);
		this.scope--;
	}

	/**
	 * Inserts a new definition into the current scope.
	 * If the definition already exists in the current scope, it will not be inserted.
	 *
	 * @param definition the definition to insert
	 * @return true if the definition was inserted, false if it already exists
	 */
	public boolean insert(Definition definition) {
		if(table.get(this.scope).containsKey(definition.getName())) {
			return false;
		}

		table.get(this.scope).put(definition.getName(), definition);
		definition.setScope(this.scope);
		return true;
	}

	/**
	 * Looks for a definition in the current scope and all parent scopes.
	 *
	 * @param id the id of the definition to look for
	 *
	 * @return the definition if found, null otherwise
	 */
	public Definition find(String id) {
		for (int i = scope; i >= 0; i--) {
			if(table.get(i).containsKey(id)) {
				return table.get(i).get(id);
			}
		}

		return null;
	}

	public Definition findInCurrentScope(String id) {
		return table.get(this.scope).get(id);
	}
}
