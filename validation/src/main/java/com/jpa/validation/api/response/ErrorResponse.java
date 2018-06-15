package com.jpa.validation.api.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 14
 * Time: 오후 4:48
 */
@Getter
@Builder
public class ErrorResponse {
    private String msg;
    private String code;
    private int status;
    private List<FiledError> filedError;

}
