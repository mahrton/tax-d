package org.taxd.remote;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = -4414015642821984680L;
	private long netPriceCents = 0;
	private ProductType productType = ProductType.OTHER;
	
	public Product(ProductType productType) {
		this.productType = productType;
	}
	
	public Product(ProductType productType, long netPriceCents) {
		this.netPriceCents = netPriceCents;
		this.productType = productType;
	}
	
	public enum ProductType {
		FOOD(7),
		MEDICINE(0), 
		OTHER(20);
		
		float vat = 0; 
		
		private ProductType(float vat) {
			this.vat = vat;
		}
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public long getNetPriceCents() {
		return netPriceCents;
	}

	public void setNetPriceCents(int netPriceCents) {
		this.netPriceCents = netPriceCents;
	}
}
