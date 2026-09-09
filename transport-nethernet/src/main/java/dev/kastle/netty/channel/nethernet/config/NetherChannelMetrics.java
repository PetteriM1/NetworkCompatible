package dev.kastle.netty.channel.nethernet.config;

import tel.schich.libdatachannel.IceState;
import tel.schich.libdatachannel.PeerState;

public interface NetherChannelMetrics {

    default void bytesIn(int count) {
    }

    default void bytesOut(int count) {
    }

    default void messagesIn(int count) {
    }

    default void messagesOut(int count) {
    }

    default void reassemblyDropped() {
    }

    default void stateChange(PeerState state) {
    }

    default void iceStateChange(IceState state) {
    }
}
