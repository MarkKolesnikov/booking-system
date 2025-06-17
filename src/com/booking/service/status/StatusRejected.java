package com.booking.service.status;

import com.booking.utils.AppStatus;

import static com.booking.utils.AppStatus.REJECTED;

public interface StatusRejected {

    default AppStatus rejected() {
        return REJECTED;
    }
}
