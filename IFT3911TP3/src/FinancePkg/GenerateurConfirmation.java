package FinancePkg;

import AdminPkg.AdminManagement;

public class GenerateurConfirmation {
		private int numeroConfirmation=1000;
		private static GenerateurConfirmation instance;
	
	public static GenerateurConfirmation getInstance()
	{
		if(instance == null)
			instance = new GenerateurConfirmation();
		return instance;
	}
	
	public int get_numeroConfirmation(){
		return ++numeroConfirmation;
	}
}
