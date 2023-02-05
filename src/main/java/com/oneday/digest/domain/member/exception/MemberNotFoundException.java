package com.oneday.digest.domain.member.exception;

import com.oneday.digest.global.error.exception.BusinessException;
import com.oneday.digest.global.error.model.ErrorCode;

public class MemberNotFoundException extends BusinessException {
    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
