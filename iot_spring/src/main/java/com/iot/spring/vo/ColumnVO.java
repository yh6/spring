package com.iot.spring.vo;

public class ColumnVO {

	private String columnName;
	private String columnDefault;
	private String nullable;
	private String dataType;
	private String characterMaximumLength;
	private String columnType;
	private String columnKey;
	private String columnComment;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnDefault() {
		return columnDefault;
	}
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}
	public String getNullable() {
		return nullable;
	}
	public void setNullable(String nullable) {
		this.nullable = nullable;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getCharacterMaximumLength() {
		return characterMaximumLength;
	}
	public void setCharacterMaximumLength(String characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	public String getColumnComment() {
		return columnComment;
	}
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	@Override
	public String toString() {
		return "ColumnVO [columnName=" + columnName + ", columnDefault=" + columnDefault + ", nullable=" + nullable
				+ ", dataType=" + dataType + ", characterMaximumLength=" + characterMaximumLength + ", columnType="
				+ columnType + ", columnKey=" + columnKey + ", columnComment=" + columnComment + "]";
	}
	
	

}
