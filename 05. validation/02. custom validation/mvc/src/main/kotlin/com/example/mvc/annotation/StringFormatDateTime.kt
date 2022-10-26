package com.example.mvc.annotation

import com.example.mvc.validator.StringFormatDateTimeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [StringFormatDateTimeValidator::class]) // StringFormatDateTime 어노테이션이 붙은 변수, field, getter, setter에 대해 해당 Validator 통해서 검증
@Target(
        // 세 군데에 Annotation 상용화 할 수 있도록 설정
        AnnotationTarget.FIELD,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME) // 런타임에만 활용할 수 있도록 지정
@MustBeDocumented
annotation class StringFormatDateTime(
        val pattern: String = "yyyy-MM-dd HH:mm:ss",
        val message: String = "시간 형식이 유효하지 않습니다",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
)