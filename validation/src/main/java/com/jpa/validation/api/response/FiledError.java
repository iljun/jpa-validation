package com.jpa.validation.api.response;

import lombok.Builder;
import lombok.Getter;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오전 11:47
 */
@Getter
@Builder
public class FiledError {
    private String filed;
    private String value;
    private String reason;

}
