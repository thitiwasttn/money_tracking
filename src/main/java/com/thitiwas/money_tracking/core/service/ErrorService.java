package com.thitiwas.money_tracking.core.service;


import com.thitiwas.money_tracking.core.exception.CustomErrorExceptionV2;
import com.thitiwas.money_tracking.core.model.CommonConstant;
import com.thitiwas.money_tracking.core.model.ErrorObj;
import com.thitiwas.money_tracking.core.model.ResponseObj;
import com.thitiwas.money_tracking.core.util.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ErrorService {
    public CustomErrorExceptionV2 createUserNotFound() {

        ErrorObj errorObj = ErrorObj.builder()
                .errorCode("400")
                .topicMessage("เกิดข้อผิดพลาด")
                .detailMessage("ไม่พบผู้ใช้งานในระบบ")
                .msg("user not found")
                .msgType(Constant.ERROR_MSG_TYPE_POPUP)
                .build();
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST,
                errorObj,
                CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 emailNotValid() {
        // return 400
        ErrorObj errorObj = ErrorObj.builder()
                .errorCode("400")
                .topicMessage("รูปแบบ Email ไม่ถูกต้อง")
                .detailMessage("Email is not valid")
                .msg("Email is not valid")
                .msgType(Constant.ERROR_MSG_TYPE_POPUP)
                .build();
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST,
                errorObj,
                CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 telnoNotValid() {
        ErrorObj errorObj = ErrorObj.builder()
                .errorCode("400")
                .topicMessage("เบอร์โทรไม่ถูกต้อง")
                .detailMessage("รูปแบบ เบอร์โทร ไม่ถูกต้อง")
                .msg("Tel number is not valid")
                .msgType(Constant.ERROR_MSG_TYPE_POPUP)
                .build();
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST,
                errorObj,
                CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 emailIsAlreadyExist() {

        ErrorObj errorObj = ErrorObj.builder()
                .msg("Email is already exist")
                .errorCode("400")
                .topicMessage("ขออภัยคุณไม่สามารถใช้อีเมลนี้ได้")
                .detailMessage("เนื่องจากมีผู้ใช้อีเมลนี้ในระบบแล้ว")
                .msgType(Constant.ERROR_MSG_TYPE_POPUP).build();

        return new CustomErrorExceptionV2(HttpStatus.OK,
                errorObj,
                CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 telNoIsAlreadyExist() {

        ErrorObj errorObj = ErrorObj.builder()
                .msg("Telno has already exist")
                .errorCode("400")
                .topicMessage("ขออภัย\\nคุณไม่สามารถใช้เบอร์นี้ได้")
                .detailMessage("เนื่องจากมีผู้ใช้เบอร์ในระบบแล้ว")
                .msgType(Constant.ERROR_MSG_TYPE_POPUP).build();

        return new CustomErrorExceptionV2(HttpStatus.OK,
                errorObj,
                CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 otpIsWrong() {
        ErrorObj errorObj = ErrorObj.builder()
                .msgType(Constant.ERROR_MSG_TYPE_ERROR_INLINE)
                .detailMessage("OTP ไม่ถูกต้อง")
                .topicMessage("")
                .errorCode("400")
                .msg("")
                .build();
        return new CustomErrorExceptionV2(HttpStatus.OK, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 otpExpired() {

        ErrorObj errorObj = ErrorObj.builder()
                .msgType(Constant.ERROR_MSG_TYPE_ERROR_INLINE)
                .detailMessage("OTP หมดอายุ")
                .topicMessage("")
                .errorCode("400")
                .msg("")
                .build();
        return new CustomErrorExceptionV2(HttpStatus.OK, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }


    public CustomErrorExceptionV2 unAuthorized() {
        ErrorObj build = ErrorObj.builder()
                .errorCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()))
                .msgType(Constant.ERROR_MSG_TYPE_POPUP)
                .topicMessage("เกิดข้อผิดพลาด")
                .detailMessage(Constant.ERROR_UNAUTH_DETAIL_MESSAGE)
                .msg("")
                .build();
        return new CustomErrorExceptionV2(HttpStatus.UNAUTHORIZED, build, CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 feignClientError(ResponseEntity<ResponseObj> response) {
        return new CustomErrorExceptionV2(response.getStatusCode(),
                Objects.requireNonNull(response.getBody()).getObjectValue(),
                response.getBody().getCode(),
                response.getBody().getStatus());
    }

    public CustomErrorExceptionV2 invalidEmailOrPassword() {
        ErrorObj build = ErrorObj.builder()
                .errorCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()))
                .msgType(Constant.ERROR_MSG_TYPE_POPUP)
                .topicMessage("email or password are wrong")
                .detailMessage("อีเมล หรือ รหัสผ่านผิด")
                .msg("invalid email or password")
                .build();
        return new CustomErrorExceptionV2(HttpStatus.UNAUTHORIZED, build, CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 notificationNotFound() {
        ErrorObj errorObj = new ErrorObj("notification not found",
                "400",
                "",
                "",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj, CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);

    }

    public CustomErrorExceptionV2 notFound() {
        ErrorObj errorObj = new ErrorObj("page not found",
                "404",
                "",
                "",
                "");
        return new CustomErrorExceptionV2(HttpStatus.NOT_FOUND, errorObj,
                CommonConstant.STATUS_ERROR_CODE, CommonConstant.STATUS_ERROR);
    }

    public CustomErrorExceptionV2 promotionNotFound() {
        ErrorObj errorObj = new ErrorObj("promotion not found",
                "400",
                "",
                "",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 outOfPromotion() {
        ErrorObj errorObj = new ErrorObj("out of promotion",
                "200",
                "out of promotion",
                "โปรโมชั่นหมดแล้ว",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.OK, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 notEnoughCoin() {
        ErrorObj errorObj = new ErrorObj("",
                "400",
                "coin ไม่พอ",
                "coin ไม่พอ",
                Constant.ERROR_MSG_TYPE_POPUP);
        throw new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST,
                errorObj,
                CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 birthDateIsNull() {
        ErrorObj errorObj = ErrorObj.builder()
                .errorCode("400")
                .topicMessage("วันเกิดไม่ถูกต้อง")
                .detailMessage("birth is not valid")
                .msg("birth is not valid")
                .msgType(Constant.ERROR_MSG_TYPE_POPUP)
                .build();
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST,
                errorObj,
                CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 formatDateInvalid() {
        ErrorObj err = new ErrorObj("format birthdate is invalid",
                "400",
                "",
                "",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, err, CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 nameIsNull() {
        ErrorObj errorObj = ErrorObj.builder()
                .errorCode("400")
                .topicMessage("ชื่อไม่ถูกต้อง")
                .detailMessage("name is null")
                .msg("")
                .msgType(Constant.ERROR_MSG_TYPE_POPUP)
                .build();
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST,
                errorObj,
                CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 genderIsInvalid() {
        ErrorObj errorObj = ErrorObj.builder()
                .errorCode("400")
                .topicMessage("เพศไม่ถูกต้อง")
                .detailMessage("gender is invalid")
                .msg("")
                .msgType(Constant.ERROR_MSG_TYPE_POPUP)
                .build();
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST,
                errorObj,
                CommonConstant.STATUS_FAIL_CODE,
                CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 notFound(String message) {
        ErrorObj errorObj = new ErrorObj(message,
                "404",
                "",
                "",
                "");
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 memberWalletNotFound() {
        ErrorObj errorObj = new ErrorObj("ไม่พบ member promotion wallet id",
                "400",
                "เกิดข้อผิดพลาด",
                "กรุณาติดต่อเจ้าหน้าที่",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 memberPromotionIsUsed() {
        ErrorObj errorObj = new ErrorObj("",
                "400",
                "เกิดข้อผิดพลาด",
                "voucher นี้ถูกใช้ไปแล้ว",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 promotionExpired() {
        ErrorObj errorObj = new ErrorObj("",
                "400",
                "เกิดข้อผิดพลาด",
                "voucher นี้หมดอายุแล้ว",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 postNotFound(String lang) {
        ErrorObj errorObj = new ErrorObj("",
                "400",
                "เกิดข้อผิดพลาด",
                "ไม่พบโพส",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 feedMemberIsAlreadyLike(String lang) {
        ErrorObj errorObj = new ErrorObj("เคยไลค์แล้ว ไม่ต้อง show นะ",
                "400",
                "เกิดข้อผิดพลาด",
                "",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 feedMemberIsAlreadyUnLike(String lang) {
        ErrorObj errorObj = new ErrorObj("เคย unlike แล้ว ไม่ต้อง show นะ",
                "400",
                "เกิดข้อผิดพลาด",
                "",
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 badRequest(String message, String detail, String topic) {
        ErrorObj errorObj = new ErrorObj(message,
                "400",
                topic,
                detail,
                Constant.ERROR_MSG_TYPE_POPUP);
        return new CustomErrorExceptionV2(HttpStatus.BAD_REQUEST, errorObj,
                CommonConstant.STATUS_FAIL_CODE, CommonConstant.STATUS_FAIL);
    }

    public CustomErrorExceptionV2 newsNotFound() {
        return badRequest("news not found", "ไม่พบ", "เกิดข้อผิดพลาด");
    }

    public CustomErrorExceptionV2 dailyLoginNotFound() {
        return badRequest("event not found", "ไม่พบ", "เกิดข้อผิดพลาด");

    }
}
