package com.piinalpin.redissentinel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataCacheDto implements Serializable {

    private static final long serialVersionUID = -7799415185617798522L;

    private String name;

    private String message;

}
