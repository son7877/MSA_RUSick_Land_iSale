package com.example.iSale.api;

import com.example.iSale.dto.response.ISaleFromLandResponse;
import com.example.iSale.global.utils.TokenInfo;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("LAND")
public interface FeignLand {

    @GetMapping("/api/v1/lands/owner/landCount")
    Map<UUID, Long> getLandsByUserId(Set<UUID> userId);
}
