# Storageblob-java-bug-whendownloadblob
Failed to download a blob to output stream. 

# Reproduce this issue
- clone this repository using Git first.

- git clone https://github.com/Luyunmt/StorageDownloadError.git

- set your storageaccount and connectString in the code. 

- In Visual Studio Code, Open-Folder your project file and run...

# StackTrace & Error Message

-Exception in thread "main" java.lang.UnsupportedOperationException
        at java.base/java.nio.ByteBuffer.array(ByteBuffer.java:1041)
        at com.azure.storage.blob.BlobClient.lambda$1(BlobClient.java:380)
        at reactor.core.publisher.FluxPeek$PeekSubscriber.onNext(FluxPeek.java:177)
        at reactor.core.publisher.FluxSwitchIfEmpty$SwitchIfEmptySubscriber.onNext(FluxSwitchIfEmpty.java:67)
        at reactor.core.publisher.FluxMap$MapSubscriber.onNext(FluxMap.java:114)
        at reactor.core.publisher.FluxDoFinally$DoFinallySubscriber.onNext(FluxDoFinally.java:123)
        at reactor.core.publisher.FluxMap$MapSubscriber.onNext(FluxMap.java:114)
        at reactor.netty.channel.FluxReceive.drainReceiver(FluxReceive.java:211)
        at reactor.netty.channel.FluxReceive.onInboundNext(FluxReceive.java:327)
        at reactor.netty.channel.ChannelOperations.onInboundNext(ChannelOperations.java:310)
        at reactor.netty.http.client.HttpClientOperations.onInboundNext(HttpClientOperations.java:504)
        at reactor.netty.channel.ChannelOperationsHandler.channelRead(ChannelOperationsHandler.java:141)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340)
        at io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.fireChannelRead(CombinedChannelDuplexHandler.java:438)
        at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:323)
        at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:297)
        at io.netty.channel.CombinedChannelDuplexHandler.channelRead(CombinedChannelDuplexHandler.java:253)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340)
        at io.netty.handler.ssl.SslHandler.unwrap(SslHandler.java:1436)
        at io.netty.handler.ssl.SslHandler.decodeJdkCompatible(SslHandler.java:1203)
        at io.netty.handler.ssl.SslHandler.decode(SslHandler.java:1247)
        at io.netty.handler.codec.ByteToMessageDecoder.decodeRemovalReentryProtection(ByteToMessageDecoder.java:502)
        at io.netty.handler.codec.ByteToMessageDecoder.callDecode(ByteToMessageDecoder.java:441)
        at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:278)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340)
        at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1408)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
        at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:930)
        at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:163)
        at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:677)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:612)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:529)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:491)
        at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:905)
        at java.base/java.lang.Thread.run(Thread.java:835)
        -Suppressed: java.lang.Exception: #block terminated with an error
                at reactor.core.publisher.BlockingSingleSubscriber.blockingGet(BlockingSingleSubscriber.java:93)
                at reactor.core.publisher.Mono.block(Mono.java:1494)
                at com.azure.storage.common.Utility.blockWithOptionalTimeout(Utility.java:241)
                at com.azure.storage.blob.BlobClient.downloadWithResponse(BlobClient.java:388)
                at com.azure.storage.blob.BlobClient.download(BlobClient.java:349)
                at Test.main(Test.java:33)