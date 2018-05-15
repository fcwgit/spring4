package com.smart.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * <br><b>类描述：</b>
 * <pre>所有PO的父类</pre>
 * @see
 * @since
 */
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = 8044742342890717787L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
