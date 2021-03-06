package net.rush.protocol.packets;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.rush.protocol.Packet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ChunkBulk extends Packet {

	private int x;
	private int z;
	private boolean groundUpContinuous;
	private int primaryBitMap;
	private int addBitMap;
	private byte[] chunkData;
	

	@Override
	public void write(ByteBuf out) throws IOException {
		out.writeInt(0);
		out.writeInt(0);
		out.writeBoolean(groundUpContinuous);
		out.writeShort(primaryBitMap);
		out.writeShort(addBitMap);
		out.writeInt(chunkData.length);
		out.writeBytes(chunkData);
	}
}
