package com.yfhl.entity;

public class Texture {

	private Integer tid;

	private String title;

	private String description;

	private String descr;

	private String img;

	private Float price;

	private String textureColor;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr == null ? null : descr.trim();
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getTextureColor() {
		return textureColor;
	}

	public void setTextureColor(String textureColor) {
		this.textureColor = textureColor == null ? null : textureColor.trim();
	}

	@Override
	public String toString() {
		return "Texture [tid=" + tid + ", title=" + title + ", description="
				+ description + ", descr=" + descr + ", img=" + img
				+ ", price=" + price + ", textureColor=" + textureColor + "]";
	}

}