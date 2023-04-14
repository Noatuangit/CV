package com.java.dto;

import com.java.utils.EmailNotExists;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;

public class CustomerDTO implements Validator {
    @Pattern(regexp = "^[A-Za-z ÚÙỤŨỦỊỈÌỈĨÂĂÔĐÊỌÒÓÕỎÁÀẢÃẠÈÉẸẼẺƯỬỮỰỪỨỐỒỔỘỖƠỞỚỠỢẾỀỂỄỆẤẦẪẨẬẶẮẲẴẰẠÁÀẢÃúùụũủịỉìỉĩâăơởớỡợôđêọòóõỏáàảãạèéẹẽẻưửữựừứốồổộỗếềểễệấầẫẩậặắẳẵằạáàảã@#]+$",
            message = " must something and no have number!")
    String name;

    String id;

    @Pattern(regexp = "^((\\(84\\)\\+)|0)9[1|0][0-9]{7}$",
            message = " must something and correct type!")
    String phone;

    @Pattern(regexp = "^[\\w\\-.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = " must something and correct type!")
    @EmailNotExists
    String email;

    @NotBlank
    String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        if (!customerDTO.getName().matches("^[A-Za-z ÚÙỤŨỦỊỈÌỈĨÂĂÔĐÊỌÒÓÕỎÁÀẢÃẠÈÉẸẼẺƯỬỮỰỪỨỐỒỔỘỖƠỞỚỠỢẾỀỂỄỆẤẦẪẨẬẶẮẲẴẰẠÁÀẢÃúùụũủịỉìỉĩâăơởớỡợôđêọòóõỏáàảãạèéẹẽẻưửữựừứốồổộỗếềểễệấầẫẩậặắẳẵằạáàảã@#]+$")) {
            errors.rejectValue("name", "name", "name not correct type.");
        }
        if (!customerDTO.getPhone().matches("^((\\(84\\)\\+)|0)9[1|0][0-9]{7}$")) {
            errors.rejectValue("phone", "phone", "phone not correct type.");
        }
        if (!customerDTO.getEmail().matches("^[\\w\\-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", "email", "email not correct type.");
        }
    }
}
