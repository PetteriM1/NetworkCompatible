package dev.kastle.netty.channel.nethernet;

public enum NetherDisconnectReason {
    HANDSHAKE_TIMEOUT,
    ICE_FAILED,
    CLOSED,
    UNKNOWN
}
