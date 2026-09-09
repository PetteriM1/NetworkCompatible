package dev.kastle.netty.channel.nethernet;

import dev.kastle.netty.channel.nethernet.config.DefaultNetherChannelConfig;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPromise;
import tel.schich.libdatachannel.PeerConnection;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class NetherNetChildChannel extends NetherNetChannel {
    private final String remoteXuid;

    public NetherNetChildChannel(Channel parent, PeerConnection peerConnection, InetSocketAddress remote, InetSocketAddress local, String remoteXuid) {
        super(parent, remote, local);
        this.peerConnection = peerConnection;
        this.config = new DefaultNetherChannelConfig(this);
        this.remoteXuid = remoteXuid;
    }

    /**
     * The XUID from the remote peer's verified NetherNet identity assertion (see
     * {@link dev.kastle.netty.util.nethernet.IdentityUtils#validateSdp}), or {@code null} if the
     * signaling implementation that accepted this connection doesn't validate one.
     */
    public String getRemoteXuid() {
        return remoteXuid;
    }

    @Override
    protected AbstractUnsafe newUnsafe() {
        return new AbstractUnsafe() {
            @Override
            public void connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
                promise.setFailure(new UnsupportedOperationException("Child channel cannot connect"));
            }
        };
    }

    @Override
    protected void doBind(SocketAddress localAddress) throws Exception {
        throw new UnsupportedOperationException("Child channel cannot be bound");
    }
}