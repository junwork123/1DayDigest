package com.oneday.digest.domain.member.exception;

import com.oneday.digest.global.error.BusinessException;
import com.oneday.digest.global.error.exception.ErrorCode;

public class MemberNotFoundException extends BusinessException {
    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
