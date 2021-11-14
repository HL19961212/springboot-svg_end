package com.kuang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    String[] list = {"(genmap)", "(tge)", "(cell_area)", "(shape_coef_gcn)", "(edge_len)", "(depth_grad)",
            "(bcond_gcn)", "(brough)", "(rho_pmean)", "(baropg)", "(adv_uv_edge_gcn)", "(vdif_uv)", "(adcor)",
            "(vertvl_edge)", "(viscofh)", "(wreal)", "(adv_q)", "(fct_q2)", "(fct_q2l)", "(vdif_q)", "(adv_t)",
            "(fct_t)", "(vdif_ts)", "(adv_s)", "(fct_s)", "(conv_over)"};
    String[] list2 = {"(genmap)", "(tge)", "(cell_area)", "(shape_coef_gcn)", "(edge_len)", "(depth_grad)",
            "bcond_gcn_run_time", "(brough)", "(rho_pmean)", "(baropg)", "(adv_uv_edge_gcn)", "(vdif_uv)", "(adcor)",
            "(vertvl_edge)", "(viscofh)", "(wreal)", "(adv_q_run_time)", "(fct_q2)", "(fct_q2l)", "(vdif_q)", "(adv_t)",
            "(fct_t)", "(vdif_ts)", "(adv_s)", "(fct_s)", "(conv_over)"};

    public String matcherRegularExpression(String str) {//str = event.getbody()
        String regex = "";
        String prefix = "[=]{4}";
        String name = null;

        for (int i = 0; i < list2.length; i++) {//  ====bcond_gcn_run_time====  9.9999997E-05
            regex = "\\s" + prefix  + list2[i] + prefix  + "\\s*" + "\\S*";
            Pattern pattern = Pattern.compile(regex);//创建一个匹配模式
            Matcher matcher = pattern.matcher(str);//多次匹配支持
            boolean found = false;
            String[] split1=null;
            while (matcher.find()) {
                System.out.println("value " + matcher.toString());
                String value = matcher.toString();
                String[] split = value.split("====  ");
                split1 = split[1].split("]");
                System.out.println(split1[0]);
                found=true;

            }
            if (found == true) {
                name = list2[i];
                name =name + " "+split1[0];
                break;
            }
        }
        return name;
    }




    public static void main(String[] args) {

    }
}
