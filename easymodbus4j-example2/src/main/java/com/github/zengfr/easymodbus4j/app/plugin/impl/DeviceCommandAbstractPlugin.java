package com.github.zengfr.easymodbus4j.app.plugin.impl;

import com.github.zengfr.easymodbus4j.app.plugin.DeviceRepositoryPlugin;
import com.github.zengfr.easymodbus4j.app.plugin.DeviceRepositoryPluginRegister;
import com.github.zengfr.easymodbus4j.channel.TransactionIdentifierBuilder;
import com.github.zengfr.easymodbus4j.codec.ModbusDecoder;
import com.github.zengfr.easymodbus4j.protocol.ModbusFrame;

import io.netty.buffer.ByteBuf;

public abstract class DeviceCommandAbstractPlugin {
	protected int calculateTransactionIdentifier() {
		return TransactionIdentifierBuilder.calculateTransactionIdentifier();
	}

	protected DeviceRepositoryPlugin getRepositoryPlugin() {
		return DeviceRepositoryPluginRegister.getInstance().get();
	}

	protected ModbusFrame byteBuf2Frame(ByteBuf buffer, boolean decodeRequest) {
		return ModbusDecoder.decode(buffer, decodeRequest);
	}

	protected ByteBuf frame2ByteBuf(ModbusFrame frame) {
		return frame.encode();
	}

}
