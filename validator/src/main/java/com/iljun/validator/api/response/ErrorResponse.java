package com.iljun.validator.api.response;

import lombok.Builder;
import lombok.Data;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오후 2:01
 */
@Data
@Builder
public class ErrorResponse {
    private String code;
    private String filed;
    private String msg;
}
