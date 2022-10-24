package com.example.demo.utils;

import com.example.demo.models.contract.ContractDetails;

import java.util.Set;

public class ConverterSetToStringHtml {
    public static String converterTable(Set<ContractDetails> set) {
        StringBuilder builder = new StringBuilder();
        for (ContractDetails contractDetails : set) {
            builder.append("<tr>");
            builder.append("<td>").append(contractDetails.getAttachService().getName()).append("</td>");
            builder.append("<td>").append(contractDetails.getQuantity()).append("</td>");
            builder.append("</tr>");
        }
        return builder.toString();
    }
}
