package io.github.pve.client.model.cluster.ceph.flags;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Set/Unset multiple ceph flags at once.
 * BY '@xiao-rao'
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetFlagsRequest {

    /**
     * Backfilling of PGs is suspended.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nobackfill")
    private Boolean nobackfill;

    /**
     * Deep Scrubbing is disabled.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nodeep-scrub")
    private Boolean nodeepScrub;

    /**
     * OSD failure reports are being ignored, such that the monitors will not mark OSDs down.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("nodown")
    private Boolean nodown;

    /**
     * OSDs that were previously marked out will not be marked back in when they start.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("noin")
    private Boolean noin;

    /**
     * OSDs will not automatically be marked out after the configured interval.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("noout")
    private Boolean noout;

    /**
     * Rebalancing of PGs is suspended.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("norebalance")
    private Boolean norebalance;

    /**
     * Recovery of PGs is suspended.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("norecover")
    private Boolean norecover;

    /**
     * Scrubbing is disabled.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("noscrub")
    private Boolean noscrub;

    /**
     * Cache tiering activity is suspended.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("notieragent")
    private Boolean notieragent;

    /**
     * OSDs are not allowed to start.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("noup")
    private Boolean noup;

    /**
     * Pauses read and writes.
     * Type: boolean
     * Optional: True
     */
    @JsonProperty("pause")
    private Boolean pause;


}
