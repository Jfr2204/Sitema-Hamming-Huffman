# Data Compression and Error Correction System
## Description

This project implements a data transmission system that combines Huffman compression with Hamming error-correcting codes.

The application compresses files using Huffman coding and then applies Hamming encoding to detect and correct transmission errors during data transfer.

The project was developed in Java as part of a university assignment related to information theory and error-correcting systems.

# Features
- Huffman file compression
- Huffman decompression
- Hamming encoding and decoding
- Single-bit error detection and correction
- Binary file processing
- File input/output handling
- Random error injection for transmission simulation
- Support for multiple Hamming block sizes

# Technologies
- Java
- BitSet manipulation
- Binary trees
- File streams
- Error-correcting codes
- Data compression algorithms

# How It Works
## Huffman Compression
The system analyzes character frequencies and builds a Huffman tree to generate variable-length binary codes. More frequent symbols receive shorter codes, reducing the total file size.

## Hamming Encoding
After compression, Hamming codes are applied to the binary data. Redundant control bits are added to detect and correct transmission errors.
The implementation supports multiple Hamming configurations, including:

- Hamming(8)
- Hamming(256)
- Hamming(8192)
- Hamming(262144)

# Error Simulation
The program can optionally introduce random bit errors to simulate noisy transmission channels and test correction capabilities.

# Project Structure
- Hamming/                 -> Hamming encoding and decoding
- Huffman/                 -> Huffman tree structures and compression logic
- FuncionesAuxiliares/     -> Bit manipulation and file utilities
- docs/                    -> Project documentation

# Technical Highlights
- Manual bit-level manipulation using BitSet
- Dynamic generation of Hamming generator and decoding matrices
- Binary encoding/decoding logic
- File reconstruction after correction
- Custom handling of binary streams and ASCII conversion
