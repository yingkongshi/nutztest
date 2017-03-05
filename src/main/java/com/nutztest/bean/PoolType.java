package com.nutztest.bean;

public enum PoolType {
  HHAD(1), HAD(2);
  private int code;

  private PoolType(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
