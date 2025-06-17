package com.booking.service.status;

import com.booking.utils.AppStatus;

import static com.booking.utils.AppStatus.APPROVED;

public interface StatusApprove {

    default AppStatus approve() {
        return APPROVED;
    }
}
