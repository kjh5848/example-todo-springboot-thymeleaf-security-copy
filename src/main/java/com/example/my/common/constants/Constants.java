package com.example.my.common.constants;

/**
 * 예외 상황에 따른 에러 코드:
 * OK = 0 → 정상 처리
 * BAD_REQUEST_EXCEPTION = -1 → 클라이언트의 잘못된 요청 (400 Bad Request)
 * MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION = -2 → 요청 파라미터 누락
 * BIND_EXCEPTION = -3 → Spring의 @Valid 등의 검증에서 실패한 경우
 * HTTP_MESSAGE_NOT_READABLE_EXCEPTION = -4 → 요청 본문을 읽을 수 없는 경우 (JSON 파싱 실패 등)
 * HTTP_REQUEST_METHOD_NOT_SUPPORT_EXCEPTION = -5 → 지원되지 않는 HTTP 메서드 사용 (예: POST 대신 GET)
 * METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION = -6 → 메서드의 파라미터 타입 불일치
 * CONVERSION_FAILED_EXCEPTION = -7 → 데이터 변환 실패
 * EXCEPTION = -99 → 기타 예외 처리
 */
public class Constants {

    public static class Regex {
        public static final String TODO_DONE_YN = "^[NY]$";
    }

    public static class ResCode {
        public static final Integer OK = 0;
        public static final Integer BAD_REQUEST_EXCEPTION = -1;
        public static final Integer MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION = -2;
        public static final Integer BIND_EXCEPTION = -3;
        public static final Integer HTTP_MESSAGE_NOT_READABLE_EXCEPTION = -4;
        public static final Integer HTTP_REQUEST_METHOD_NOT_SUPPORT_EXCEPTION = -5;
        public static final Integer METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION = -6;
        public static final Integer CONVERSION_FAILED_EXCEPTION = -7;
        public static final Integer EXCEPTION = -99;
    }

}

