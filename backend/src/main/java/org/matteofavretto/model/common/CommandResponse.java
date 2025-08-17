package org.matteofavretto.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandResponse {
    public enum Status {
        OK,
        KO
    }
    private Object response;
    private Status status;
    private String errorMessage = null;

    public CommandResponse(Object response, Status status) {
        this.response = response;
        this.status = status;
        this.errorMessage = null;
    }
}
