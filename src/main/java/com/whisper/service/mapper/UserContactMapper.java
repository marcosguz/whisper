package com.whisper.service.mapper;

import com.whisper.model.UserContact;
import com.whisper.service.dto.UserContactDto;

public interface UserContactMapper {
    UserContactDto userContactToUserContactDto(UserContact userContact);
    UserContact userContactDtoToUserContact(UserContactDto userContactDto);
}
