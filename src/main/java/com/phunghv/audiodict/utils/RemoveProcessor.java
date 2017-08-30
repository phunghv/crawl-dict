package com.phunghv.audiodict.utils;

import java.util.ArrayList;
import java.util.List;

public class RemoveProcessor {
	List<IRemover> removers = new ArrayList<IRemover>();

	public String process(String content) {
		String result = content;
		for (IRemover remover : removers) {
			result = remover.remove(result);
		}
		return result;
	}

	public void addRemover(IRemover remover) {
		this.removers.add(remover);
	}
}
